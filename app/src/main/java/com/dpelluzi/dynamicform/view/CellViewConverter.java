package com.dpelluzi.dynamicform.view;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpelluzi.dynamicform.R;
import com.dpelluzi.dynamicform.models.Cell;

public class CellViewConverter {

    private LayoutInflater mInflater;

    public CellViewConverter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public View convert(Cell cell) {
        View view;
        switch (cell.getType()) {
            case Cell.CellType.FIELD:
                view = convertToEditText(cell);
                break;
            case Cell.CellType.TEXT:
                view = convertToTextView(cell);
                break;
            case Cell.CellType.IMAGE:
                view = convertToImageView(cell);
                break;
            case Cell.CellType.CHECKBOX:
                view = convertToCheckbox(cell);
                break;
            case Cell.CellType.SEND:
                view = convertToButton(cell);
                break;
            default:
                view = null;
        }

        if (view != null) {
            view.setId(cell.getId());
            view.setTag(cell);
            view.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
        }

        return view;
    }

    private View convertToCheckbox(Cell cell) {
        CheckBox checkBox = (CheckBox) mInflater.inflate(R.layout.view_template_checkbox, null);
        checkBox.setText(cell.getMessage());
        return checkBox;
    }

    private Button convertToButton(Cell cell) {
        Button button = (Button) mInflater.inflate(R.layout.view_template_button, null);
        button.setText(cell.getMessage());
        return button;
    }

    private ImageView convertToImageView(Cell cell) {
        return (ImageView) mInflater.inflate(R.layout.view_template_image, null);
    }

    private TextView convertToTextView(Cell cell) {
        TextView textView = (TextView) mInflater.inflate(R.layout.view_template_text, null);
        textView.setText(cell.getMessage());
        return textView;
    }

    private TextInputLayout convertToEditText(Cell cell) {
        TextInputLayout inputLayout = (TextInputLayout) mInflater.inflate(R.layout.view_template_field, null);
        inputLayout.setHint(cell.getMessage());

        TextInputEditText textInput = (TextInputEditText) inputLayout.findViewById(R.id.text_input);
        textInput.setInputType(getKeyboardType(cell.getTypeField()));
        if (cell.getTypeField() == Cell.FieldType.TEL_NUMBER) {
            textInput.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        }

        return inputLayout;
    }

    private int getKeyboardType(@Cell.FieldType int fieldType) {
        int keyboardType;

        if (fieldType == Cell.FieldType.TEL_NUMBER) {
            keyboardType = InputType.TYPE_CLASS_PHONE;
        } else if (fieldType == Cell.FieldType.EMAIL) {
            keyboardType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
        } else {
            keyboardType = InputType.TYPE_CLASS_TEXT;
        }

        return keyboardType;
    }

}
