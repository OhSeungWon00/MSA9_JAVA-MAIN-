package mission13;

public class LottoMachine {

	int first;
	int second;
	int third;
	int fourth;
	int fifth;
	int sixth;
	String choose;

	public LottoMachine() {

	}

	public LottoMachine(int first, int second, int third, int fourth, int fifth, int sixth, String choose) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.choose = choose;

	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getFourth() {
		return fourth;
	}

	public void setFourth(int fourth) {
		this.fourth = fourth;
	}

	public int getFifth() {
		return fifth;
	}

	public void setFifth(int fifth) {
		this.fifth = fifth;
	}

	public int getSixth() {
		return sixth;
	}

	public LottoMachine(String choose) {
		if(choose == "1") {
			this.choose = "자 동";
		}else {
			this.choose = "수 동";
		}

	}


	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public void setSixth(int sixth) {
		this.sixth = sixth;
	}

	@Override
	public String toString() {
		return "LottoMachine [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth
				+ ", fifth=" + fifth + ", sixth=" + sixth + ", choose=" + choose + "]";
	}

	

	
	
	
}
