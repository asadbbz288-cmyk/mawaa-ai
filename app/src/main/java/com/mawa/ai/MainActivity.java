package com.mawa.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    int white = Color.WHITE;
    int purple = Color.rgb(153, 110, 255);

    int dp(float v) {
        return (int)(v * getResources().getDisplayMetrics().density);
    }

    GradientDrawable shape(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        return t;
    }

    ImageView image(String file) {
        ImageView img = new ImageView(this);
        try {
            img.setImageBitmap(BitmapFactory.decodeStream(
                getAssets().open(file)
            ));
        } catch (Exception e) {}
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return img;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(15, 12, 35));
        getWindow().setNavigationBarColor(Color.rgb(15, 12, 35));

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(14), dp(20), dp(18));

        GradientDrawable bg = new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{
                Color.rgb(12, 10, 32),
                Color.rgb(35, 20, 75),
                Color.rgb(12, 14, 40)
            }
        );
        root.setBackground(bg);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.addView(root);

        // Header
        LinearLayout header = new LinearLayout(this);
        header.setGravity(Gravity.CENTER_VERTICAL);
        header.setOrientation(LinearLayout.HORIZONTAL);

        ImageView logo = image("mawa_logo.jpg");
        logo.setBackground(shape(Color.WHITE, 16));
        logo.setPadding(dp(3), dp(3), dp(3), dp(3));
        header.addView(logo, new LinearLayout.LayoutParams(dp(52), dp(52)));

        LinearLayout brand = new LinearLayout(this);
        brand.setOrientation(LinearLayout.VERTICAL);
        brand.setPadding(dp(12), 0, 0, 0);

        TextView name = text("MAWA AI", 22, white);
        name.setTypeface(null, Typeface.BOLD);
        brand.addView(name);
        brand.addView(text("YOUR PERSONAL ASSISTANT", 10,
            Color.rgb(190, 175, 235)));

        header.addView(brand, new LinearLayout.LayoutParams(
            0, -2, 1
        ));

        TextView online = text("● ONLINE", 11,
            Color.rgb(120, 255, 190));
        header.addView(online);
        root.addView(header);

        // Welcome text
        TextView welcome = text("Hello! I'm MAWA ✨", 23, white);
        welcome.setTypeface(null, Typeface.BOLD);
        welcome.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams wp =
            new LinearLayout.LayoutParams(-1, -2);
        wp.topMargin = dp(25);
        root.addView(welcome, wp);

        TextView subtitle = text(
            "Your friendly AI assistant",
            14, Color.rgb(195, 185, 225)
        );
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        // Anime Character
        ImageView character = image("mawa_character.png");
        LinearLayout.LayoutParams cp =
            new LinearLayout.LayoutParams(-1, dp(285));
        cp.topMargin = dp(12);
        root.addView(character, cp);

        // Character status
        TextView status = text(
            "✦  Ready to chat with you  ✦",
            13, Color.rgb(220, 205, 255)
        );
        status.setGravity(Gravity.CENTER);
        status.setPadding(dp(15), dp(11), dp(15), dp(11));
        status.setBackground(shape(Color.rgb(55, 38, 95), 30));

        LinearLayout.LayoutParams sp =
            new LinearLayout.LayoutParams(-2, -2);
        sp.gravity = Gravity.CENTER;
        sp.topMargin = dp(8);
        root.addView(status, sp);

        // Language section
        TextView language = text(
            "BENGALI  •  ENGLISH  •  HINDI",
            11, Color.rgb(190, 175, 235)
        );
        language.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp =
            new LinearLayout.LayoutParams(-1, -2);
        lp.topMargin = dp(22);
        root.addView(language, lp);

        TextView prompt = text(
            "What can I help you with?",
            18, white
        );
        prompt.setTypeface(null, Typeface.BOLD);
        prompt.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams pp =
            new LinearLayout.LayoutParams(-1, -2);
        pp.topMargin = dp(18);
        root.addView(prompt, pp);

        // Chat input
        LinearLayout chat = new LinearLayout(this);
        chat.setGravity(Gravity.CENTER_VERTICAL);
        chat.setPadding(dp(12), dp(6), dp(7), dp(6));
        chat.setBackground(shape(Color.rgb(48, 39, 78), 28));

        EditText input = new EditText(this);
        input.setSingleLine(true);
        input.setTextColor(white);
        input.setHintTextColor(Color.rgb(175, 165, 200));
        input.setHint("Type your message...");
        input.setTextSize(14);
        input.setBackgroundColor(Color.TRANSPARENT);
        chat.addView(input, new LinearLayout.LayoutParams(
            0, dp(48), 1
        ));

        TextView send = text("➤", 22, white);
        send.setGravity(Gravity.CENTER);
        send.setBackground(shape(Color.rgb(130, 85, 220), 25));
        chat.addView(send, new LinearLayout.LayoutParams(
            dp(48), dp(48)
        ));

        LinearLayout.LayoutParams chatParams =
            new LinearLayout.LayoutParams(-1, -2);
        chatParams.topMargin = dp(15);
        root.addView(chat, chatParams);

        TextView footer = text(
            "MAWA AI  •  Made for you",
            11, Color.rgb(145, 135, 180)
        );
        footer.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams fp =
            new LinearLayout.LayoutParams(-1, -2);
        fp.topMargin = dp(20);
        root.addView(footer, fp);

        setContentView(scroll);
    }
}
