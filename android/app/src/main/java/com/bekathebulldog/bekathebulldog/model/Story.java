package com.bekathebulldog.bekathebulldog.model;


import com.bekathebulldog.bekathebulldog.R;


public class Story {
    private Page[] mPages;

    public Story() {
        mPages = new Page[7]; //We need to change this number to the amount of stories there are.

        mPages[0] = new Page(
                R.drawable.page0,
                "Hello %1$s! This is Beka. She is sleeping now but she would like to go on an adventure with you. What would you like to do first?",
                new Choice(R.drawable.to_page1, 1),
                new Choice(R.drawable.to_page2, 2));

        mPages[1] = new Page(
                R.drawable.page1,
                "You and Beka are having so much fun! Her friends show up and want to play with you too but you might be a little tired from all the running around. What do you want to do?",
                new Choice(R.drawable.to_page4, 4),
                new Choice(R.drawable.to_page5, 5));

        mPages[2] = new Page(
                R.drawable.page2,
                "You and Beka go for a car ride. You both have your seat-belt ON so you can enjoy the ride safely. Beka wants to put her head out the window but she also wants to go to the park. What do you want %1$s?",
                new Choice(R.drawable.to_page1, 1),
                new Choice(R.drawable.to_page3, 3));

        mPages[3] = new Page(
                R.drawable.page3,
                "Beka loves the air on her face, but she also wants you to know that you shouldn't do it. Now Beka is a little tired",
                new Choice(R.drawable.to_page5, 5),
                new Choice(R.drawable.to_page6, 6));

        mPages[4] = new Page(
                R.drawable.page4,
                "Wohooo! You are having a great time with Beka, Gatsby, and Oliver. Now you are really getting tired. Do you want to...",
                new Choice(R.drawable.to_page5, 5),
                new Choice(R.drawable.to_page6, 6));

        mPages[5] = new Page(
                R.drawable.page5,
                "You and Beka take a nap together and then you say goodbye to her.");

        mPages[6] = new Page(
                R.drawable.page6,
                "After a beautiful day with Beka, you let her play calmly with her favorite toy. You are both very happy and a little tired so it is better if you rest until your next adventure. "
                );

    }

    public Page getPage(int pageNumber) {
        return mPages[pageNumber];
    }

}
