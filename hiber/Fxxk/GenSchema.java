import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenSchema {

	public static void main(String[] args) {
		
		SchemaExport export = new SchemaExport( (new Configuration()).configure());
    System.out.println("Creating tables...");
//		export.create(true, false);
		export.create(true, true);
	}
}
