package com.dpelluzi.dynamicform.presenters;

import com.dpelluzi.dynamicform.interfaces.FormContract;
import com.dpelluzi.dynamicform.models.Cell;
import com.dpelluzi.dynamicform.models.CellCollection;
import com.dpelluzi.dynamicform.util.FieldValidator;

public class FormPresenter implements FormContract.Presenter {

    private FormContract.View mView;
    private CellCollection mCellCollection;

    public FormPresenter(FormContract.View view) {
        mView = view;
        mCellCollection = CellCollection.loadCells();
    }

    @Override
    public void onViewCreated() {
        mView.insertCells(mCellCollection.getCells());
    }

    @Override
    public void onCellClicked(Cell cell) {
        if (cell.getType() == Cell.CellType.SEND) {
            validateFields();
            return;
        }

        if (cell.getShow() != 0) {
            boolean selected = mView.isCellSelected(cell.getId());
            if (selected) {
                mView.showCell(cell.getShow());
            } else {
                mView.hideCell(cell.getShow());
            }
        }
    }

    private void validateFields() {
        for (Cell cell : mCellCollection.getCells()) {
            if (cell.getType() == Cell.CellType.FIELD) {
                mView.clearError(cell.getId());

                String inputText = mView.getInputText(cell.getId());
                boolean isVisible = mView.isCellVisible(cell.getId());

                FieldValidator validator = FieldValidator.getInstance(cell.getTypeField());

                if (isVisible && !validator.validate(inputText)) {
                    mView.setInputTextError(cell.getId());
                    return;
                }
            }
        }

        mView.startSuccessScreen();
    }
}
