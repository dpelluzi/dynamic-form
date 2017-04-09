package com.dpelluzi.dynamicform.interfaces;

import com.dpelluzi.dynamicform.models.Cell;

import java.util.List;

public interface FormContract {

    interface Presenter {

        void onViewCreated();

        void onCellClicked(Cell cell);
    }

    interface View {

        void insertCells(List<Cell> cells);

        void showCell(int cellId);

        boolean isCellSelected(int cellId);

        void hideCell(int cellId);

        String getInputText(int cellId);

        void startSuccessScreen();

        void setInputTextError(int cellId);

        void clearError(int cellId);

        boolean isCellVisible(int cellId);
    }

}
