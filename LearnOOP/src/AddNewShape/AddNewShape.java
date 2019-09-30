/*AddNewShape.java*/

package AddNewShape;

import cHabit.c;
import processControl.*;

public class AddNewShape extends ProcessControl {

	public void display() {
		c.ln();
		c.println("What Shape do you would like to add:");
		c.println("1. Circle");
		c.println("2. Square");
		c.println("3. EquivalentTriangle");
		c.println("4. Rectangle");
		c.println("5. Quit");
		c.ln();
	}
	
	public void part() {
		display();
		selection(new AddCircle(),
				  new AddSquare(),
				  new AddEquivalentTriangle(),
				  new AddRectangle(),
				  new Quit() );
	}
}
