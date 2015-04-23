package net.codingchick.androidgithubdemo.views.fragments;


import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.graphics.Palette;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.utils.CircleTransform;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class RepoDetailsFragment extends Fragment {
   
    private static final String ARG_REPO = "repo";

    private Repo repo;
    @InjectView(R.id.avatar_full_image)  ImageView avatarImageView;
    @InjectView(R.id.repo_full_name_text)  TextView repoFullNameText;
    @InjectView(R.id.details_description)  TextView detailsDescription;
    @InjectView(R.id.repo_link)  TextView repoLink;
    @InjectView(R.id.fork_text)  TextView forkText;
    @InjectView(R.id.star_text) TextView starText;
    @InjectView(R.id.watchers_text)  TextView watchersText;
    @InjectView(R.id.header_background)  ViewGroup headerBackground;

    public static RepoDetailsFragment newInstance(Repo repo) {
        RepoDetailsFragment fragment = new RepoDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_REPO, repo);
        fragment.setArguments(args);
        return fragment;
    }

    public RepoDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            repo = getArguments().getParcelable(ARG_REPO);
        }

        getActivity().getActionBar().hide();
    }
    Palette palette;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_repo_details, container, false);

        ButterKnife.inject(this, view);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        repoLink.setClickable(true);
        repoLink.setMovementMethod(LinkMovementMethod.getInstance());

        Picasso.with(getActivity())
                .load(repo.getOwner().getAvatarUrl())
                .into(new PaletteTarget());

        repoFullNameText.setText(repo.getFullName());
        detailsDescription.setText(repo.getDescription());
        starText.setText(String.valueOf(repo.getStargazersCount()));
        forkText.setText(String.valueOf(repo.getForksCount()));
        watchersText.setText(String.valueOf(repo.getWatchersCount()));
        String text = String.format("<a href='%s'> %s </a>", repo.getHtmlUrl(), repo.getHtmlUrl());
        repoLink.setText(Html.fromHtml(text));

        WebView readmeView = (WebView) view.findViewById(R.id.readme_view);
        readmeView.loadUrl(repo.getHtmlUrl() + "/blob/master/README.md");
        return view;
    }

    public class PaletteTarget implements Target {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            palette =  Palette.generate(bitmap);

            avatarImageView.setImageDrawable(new BitmapDrawable(bitmap));

            hasPaletteWillTravel();
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    }

    private void hasPaletteWillTravel() {
        headerBackground.setBackgroundColor(palette.getLightVibrantColor(R.color.primary));
        repoFullNameText.setTextColor(palette.getDarkMutedColor(R.color.accent));

        if (detailsDescription.getText() != null){
            detailsDescription.setTextColor(palette.getDarkMutedColor(R.color.primary_light));
        }
        repoFullNameText.setLinkTextColor(palette.getDarkMutedColor(R.color.accent));
    }
}
