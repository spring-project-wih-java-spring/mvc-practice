package test_code3;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {

        validate(value);

        this.value = value;
    }

    private void validate(int value) {
        if(isMinus(value)){
            throw new IllegalArgumentException("0또는 음스룰 전달 불가");
        }
    }

    private boolean isMinus(int value){
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
