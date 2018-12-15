import java.util.Scanner;

class FreshJuice {
	double amount;
	String taste;

	public enum FreshJuiceSize{small,medium,large}
	
	FreshJuiceSize size;
	
	FreshJuice(){
		this.amount = 0.5;
		this.taste = "orange";	
	}
	
	
	static void setEnumFJS(String fjs){  //ne razumem kaj naredim narobe tukej
		FreshJuiceSize size = FreshJuiceSize.valueOf(fjs);
	}
	
	
	FreshJuice(double a){
		this.amount = a;
		this.taste = "orange";	
	}
	
	FreshJuice(double a,String t){
		this.amount = a;
		this.taste = t.toLowerCase();
	}
	
	FreshJuice(double a,String t,String e){
		this.amount = a;
		this.taste = t.toLowerCase();
		FreshJuiceSize size = FreshJuiceSize.valueOf(e.toLowerCase());
	}
	
	
}

public class FreshJuiceTest {
	public static void main(String args[]){
		Scanner ScannerIn = new Scanner(System.in);
		FreshJuice juice1 = new FreshJuice();
		System.out.println("What is the taste of your juice?");
		juice1.taste = ScannerIn.next();
		System.out.println("Size of glass?(Small/Medium/Large)");
		String s = ScannerIn.next().toLowerCase();
		juice1.setEnumFJS(s);//tale metoda me heca ...
		/* switch(s){
		case "medium":
			juice1.size = FreshJuice.FreshJuiceSize.medium;
			break;
		case "small":
			juice1.size = FreshJuice.FreshJuiceSize.small;
			break;
		case "large":
			juice1.size = FreshJuice.FreshJuiceSize.large;
			break;
		default:
			juice1.size = FreshJuice.FreshJuiceSize.medium;
		} */
		System.out.println("What % full is your glass?");
		juice1.amount = ScannerIn.nextDouble()/100;
		
		FreshJuice juice2 = new FreshJuice(0.69, "Apple", "large");
		
		Report(juice1);
		Report(juice2);
		
	}
	
	static void Report(FreshJuice a){
		double c = a.amount * 100;
		System.out.println("You have " + a.taste + " juice in " + a.size + " glass that is " + (int)c + " percent full.");
	}
	
}