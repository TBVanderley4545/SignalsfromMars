package com.tbvanderleystudios.signalsfrommars.model;

import com.tbvanderleystudios.signalsfrommars.R;

public class Story {
    private Page[] mPages;

    public Story() {
        mPages = new Page[7];

        // Initializing the Page[]. It looks complicated, but I just
        // separated lines for readability.
        mPages[0] = new Page(
                R.drawable.page0,
                R.string.page_0_text,
                new Choice(R.string.page_0_choice_0, 1),
                new Choice(R.string.page_0_choice_1, 2)
        );
        mPages[1] = new Page(
                R.drawable.page1,
                R.string.page_1_text,
                new Choice(R.string.page_1_choice_0, 3),
                new Choice(R.string.page_1_choice_1, 4)
        );
        mPages[2] = new Page(
                R.drawable.page2,
                R.string.page_2_text,
                new Choice(R.string.page_2_choice_0, 4),
                new Choice(R.string.page_3_choice_1, 6)
        );
        mPages[3] = new Page(
                R.drawable.page3,
                R.string.page_3_text,
                new Choice(R.string.page_3_choice_0, 4),
                new Choice(R.string.page_3_choice_1, 5)
        );
        mPages[4] = new Page(
                R.drawable.page4,
                R.string.page_4_text,
                new Choice(R.string.page_4_choice_0, 5),
                new Choice(R.string.page_4_choice_1, 6)
        );
        mPages[5] = new Page(
                R.drawable.page5,
                R.string.page_5_text
        );
        mPages[6] = new Page(
                R.drawable.page6,
                R.string.page_6_text
        );
    }

    public Page getPage(int pageNumber) {
        return mPages[pageNumber];
    }
}
