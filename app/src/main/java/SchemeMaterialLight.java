package com.bluewhaleyt.javaclassextract;

import android.graphics.Color;
import com.bluewhaleyt.javaclassextract.R;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;

/*
    Material Light theme (non TextMate) for Rosemoe sora editor
    by BlueWhaleYT, feel free to use it.
*/

public class SchemeMaterialLight extends EditorColorScheme {
    
    /*
        Extracted from CodeStudio.
        Converted from MaterialPalenight to MaterialLight.
    */

	// colors to be used
	public static int purple = Color.parseColor("#7c4dff");
	public static int lightBlue = Color.parseColor("#39adb5");
	public static int blue = Color.parseColor("#6182b8");
	public static int lime = Color.parseColor("#91b859");
	public static int red = Color.parseColor("#e53935");
	public static int orange = Color.parseColor("#f76d47");
	public static int yellow = Color.parseColor("#f6a434");
	public static int cyan = Color.parseColor("#39adb5");
	public static int lightGrey = Color.parseColor("#d2d4d5");
	public static int grey = Color.parseColor("#aabfc9");

	public static int normal = Color.parseColor("#546e7a");

	public static int colorAccent = Color.parseColor("#444aff");

	@Override
	public void applyDefault() {
		super.applyDefault();

		// background color
		setColor(WHOLE_BACKGROUND, Color.parseColor("#fafafa"));

		// text color
		setColor(TEXT_NORMAL, normal);

		// line number background
		setColor(LINE_NUMBER_BACKGROUND, Color.parseColor("#fafafa"));
		setColor(LINE_DIVIDER, Color.TRANSPARENT);
		setColor(LINE_NUMBER_PANEL, Color.parseColor("#fafafa"));

		// line number text color
		setColor(LINE_NUMBER, grey);
		setColor(LINE_NUMBER_PANEL_TEXT, grey);

		// current line background color
		setColor(CURRENT_LINE, Color.parseColor("#e7e7e8"));
		setColor(BLOCK_LINE_CURRENT, lightGrey);
		setColor(BLOCK_LINE, grey);

		// selected text background color
		setColor(SELECTED_TEXT_BACKGROUND, Color.parseColor("#80cbc4"));

		// selections
		setColor(SELECTION_HANDLE, colorAccent);
		setColor(SELECTION_INSERT, colorAccent);

		/* Java - Syntax Highlights */

		// keywords
		setColor(KEYWORD, purple);

		// identifiers
		setColor(IDENTIFIER_NAME, yellow);
		setColor(IDENTIFIER_VAR, blue);

		// functions
		setColor(FUNCTION_NAME, blue);

		// annotations
		setColor(ANNOTATION, lightBlue);

		// literals
		setColor(LITERAL, lime);

		// operators
		setColor(OPERATOR, lightBlue);

		// comments
		setColor(COMMENT, grey);

	}

}
