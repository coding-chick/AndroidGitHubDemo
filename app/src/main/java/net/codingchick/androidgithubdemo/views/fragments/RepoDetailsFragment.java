package net.codingchick.androidgithubdemo.views.fragments;


import android.graphics.Point;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.utils.CircleTransform;

import org.w3c.dom.Text;


public class RepoDetailsFragment extends Fragment {
   
    private static final String ARG_REPO = "repo";

    private Repo repo;
    private ImageView avatarImageView;
    private TextView repoFullNameText;
    private TextView starText;
    private TextView ownerName;

   
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_repo_details, container, false);
        avatarImageView = (ImageView) view.findViewById(R.id.avatar_full_image);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        avatarImageView.setLayoutParams(new RelativeLayout.LayoutParams(size.x, size.x));
        Picasso.with(getActivity())
                .load(repo.getOwner().getAvatarUrl())
                .fit()
                .centerCrop()
                .into(avatarImageView);

        repoFullNameText = (TextView) view.findViewById(R.id.repo_full_name_text);
        repoFullNameText.setText(repo.getFullName());

        starText = (TextView) view.findViewById(R.id.star_text);
        starText.setText(String.valueOf(repo.getStargazersCount()));

        ownerName = (TextView) view.findViewById(R.id.owner_name);
        ownerName.setClickable(true);
        ownerName.setMovementMethod(LinkMovementMethod.getInstance());
        String text = String.format("<a href='%s'> %s </a>", repo.getOwner().getHtmlUrl(), repo.getOwner().getLogin());
        ownerName.setText(Html.fromHtml(text));

        return view;
    }


}
