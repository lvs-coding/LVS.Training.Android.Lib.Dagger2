package com.example.dagger2training.screens.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dagger2training.R;
import com.example.dagger2training.models.GithubRepo;
import com.squareup.picasso.Picasso;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


@SuppressLint("ViewConstructor")
public class RepoListItem extends FrameLayout {

    @BindView(R.id.user_avatar)
    ImageView avatarImage;

    @BindView(R.id.repo_name)
    TextView name;

    @BindView(R.id.repo_description)
    TextView description;

    @BindView(R.id.repo_stars)
    TextView stars;

    @BindView(R.id.repo_issues)
    TextView issues;

    @BindView(R.id.repo_forks)
    TextView forks;

    @BindView(R.id.repo_updated_at)
    TextView updatedAt;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.fullDate();

    public RepoListItem(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.list_item_repo, this);
        ButterKnife.bind(this);
    }

    public void setRepo(GithubRepo githubRepo) {
        Locale locale = getResources().getConfiguration().locale;

        name.setText(githubRepo.name);
        description.setVisibility(TextUtils.isEmpty(githubRepo.description) ? GONE : VISIBLE);
        description.setText(githubRepo.description);

        stars.setText(String.format(locale, "%d", githubRepo.stargazersCount));
        issues.setText(String.format(locale, "%d", githubRepo.openIssuesCount));
        forks.setText(String.format(locale, "%d", githubRepo.forksCount));

        updatedAt.setText(DATE_TIME_FORMATTER.print(githubRepo.updatedAt));

        updatedAt.setText(getResources()
                .getString(R.string.last_pushed, DATE_TIME_FORMATTER.print(githubRepo.updatedAt)));

        Picasso.with(getContext())
                .load(githubRepo.owner.avatarUrl)
                .placeholder(R.drawable.ic_person_black_24dp)
                .into(avatarImage);
    }
}