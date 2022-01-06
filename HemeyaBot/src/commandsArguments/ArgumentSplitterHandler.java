package commandsArguments;

public class ArgumentSplitterHandler {
	
	public static void embedSplitterHandler(String[] arg) {
		String[][] splittedArgs = new String[2][2];// = args.split(",");
		String args = arg[1];
		
		String[] arrOne = new String[2];
		arrOne = args.split(",");
		for(int j=0; j<arrOne.length; j++) {
			splittedArgs[j] = arrOne[j].split("=");
			for(int k=0; k<splittedArgs[j].length; k++) {
				System.out.println(splittedArgs[j][k] + " ");
			}
		}
			
			/*
			comaPlittedArgs[i] = args[i].split(",");
			String[] temp = args[i].split(",");
			for(int j=0; j<comaPlittedArgs[i].length; j++) {
				comaPlittedArgs[i][j] = temp.split("1");
			}*/
		
		
	}
}
