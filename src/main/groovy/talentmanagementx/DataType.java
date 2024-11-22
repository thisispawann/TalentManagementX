package talentmanagementx;

import com.aspose.cells.CellValueType;

public enum DataType {
    INTEGER_WITH_COMMA(4, CellValueType.IS_NUMERIC),
    STRING(0, CellValueType.IS_STRING),
    DATE(14, CellValueType.IS_DATE_TIME);

    int styleNumber;
    int internalType;

    DataType(int styleNumber, int internalType) {
        this.styleNumber = styleNumber;
        this.internalType = internalType;
    }
}
