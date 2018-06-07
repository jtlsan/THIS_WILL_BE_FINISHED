package template;

public class Main {

	public static void main(String[] args) {
		// Make View Object
				Template1 view=new Template1();
				new AllListener(view.ToolSave, view.FileChooser);
				
	}

}
