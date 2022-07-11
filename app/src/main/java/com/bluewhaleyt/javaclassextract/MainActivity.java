package com.bluewhaleyt.javaclassextract;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.*;
import com.google.android.material.textfield.*;
import io.github.rosemoe.sora.*;
import io.github.rosemoe.sora.langs.java.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import com.bluewhaleyt.javaclassextract.SchemeMaterialLight;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;;


public class MainActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private CodeEditor code_editor;
	private TextInputLayout et_layout_class;
	private MaterialButton btn_extract;
	private EditText et_class;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		code_editor = findViewById(R.id.code_editor);
		et_layout_class = findViewById(R.id.et_layout_class);
		btn_extract = findViewById(R.id.btn_extract);
		et_class = findViewById(R.id.et_class);
		
		btn_extract.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_extractJavaClass(et_class.getText().toString());
			}
		});
	}
	
	private void initializeLogic() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		((EditText)et_class).setMaxLines((int)1);
		et_class.setSingleLine(true);
		_editorSetup();
	}
	
	public void _editorSetup() {
		code_editor.setText("// Use sora-editor (current ver: 0.10.0) because it brings syntax highlighting which makes you easier inspect the extracted classes.\n\n// You can try out classes but not all are avaliable.\n/*\n    Available Examples:\n    com.bluewhaleyt.javaclassextract.MainActivity\n    java.io.File\n    org.json.JSONArray\n    android.os.Bundle\n    androidx.appcompat.app.AppCompatActivity\n*/\n// Material Light theme customized by BlueWhaleYT. \n// This project is a lite version (non TextMate) which is extracted as a part from CodeStudio.");
		code_editor.setTypefaceText(Typeface.createFromAsset(getAssets(), "fonts/jetbrains.ttf"));
		code_editor.setTypefaceLineNumber(Typeface.createFromAsset(getAssets(), "fonts/jetbrains.ttf"));
		code_editor.setTextSize(14);
		code_editor.setEditable(false);
		code_editor.setEditorLanguage(new JavaLanguage());
		code_editor.setColorScheme(new SchemeMaterialLight());
	}
	
	
	public void _extractJavaClass(final String _className) {
		try {
			Class cls = Class.forName(_className);
			if(cls != null) {
				String text = "// Extracted class: " + cls.getName();
				
				if(cls.getDeclaredAnnotations().length != 0){
					text += "\n\n// Annotations";
				}
				for (Annotation a : cls.getDeclaredAnnotations()) {
					text += "\n\n" + a.toString();
				}
				
				if(cls.getDeclaredFields().length != 0){
					text += "\n\n// Fields";
				}
				for (Field f : cls.getDeclaredFields()) {
					text += "\n\n" + f.toString();
				}
				
				if(cls.getDeclaredConstructors().length != 0){
					text += "\n\n// Constructors";
				}
				for (Constructor c : cls.getDeclaredConstructors()) {
					text += "\n\n" + c.toString();
				}

				if(cls.getDeclaredMethods().length != 0){
					text += "\n\n// Methods";
				}
				for (Method m : cls.getDeclaredMethods()) {
					text += "\n\n" + m.toString();

				}
				
				if(cls.getDeclaredClasses().length != 0){
					text += "\n\n// Classes";
				}
				for (Class c : cls.getDeclaredClasses()) {
					text += "\n\n" + c.toString();
				}
				
				code_editor.setText(text);
				
			}
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), e.getMessage());
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
