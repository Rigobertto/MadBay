package medbay.model.util;

public class Texto {
	/*public static String removerAcentos(String fonte) {
		String src = new String(fonte);
		src = src.replaceAll("[�����]","A"); 
		src = src.replaceAll("[�����]","a"); 
		src = src.replaceAll("[����]","E"); 
		src = src.replaceAll("[����]","e"); 
		src = src.replaceAll("����","I"); 
		src = src.replaceAll("����","i"); 
		src = src.replaceAll("[�����]","O"); 
		src = src.replaceAll("[�����]","o"); 
		src = src.replaceAll("[����]","U"); 
		src = src.replaceAll("[����]","u"); 
		src = src.replaceAll("�","C"); 
		src = src.replaceAll("�","c");  
		src = src.replaceAll("[��]","y"); 
		src = src.replaceAll("�","Y"); 
		src = src.replaceAll("�","n"); 
		src = src.replaceAll("�","N"); 
		return src; 
	}*/
	
	public static boolean contem(String fonte, String pesquisa) {
		String src = new String(fonte);
		String search = new String(pesquisa);
		
		src = src.toLowerCase();
		search = search.toLowerCase();
		
		if(src.contains(search)) return true;
		
		else return false;
	}
}
