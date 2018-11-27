package empleado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Empleado> misEmpleados = new ArrayList<Empleado>();
		Empleado e1 = new Empleado("Oliver", 35, 25000);
		Empleado e2 = new Empleado("Maria", 30, 39090);
		misEmpleados.add(e1);
		misEmpleados.add(e2);
		// Comprobamos que el atributo clave no es NULL y es "patata"
		for (Empleado e : misEmpleados) {
			System.out.println(e);
		}

		File archivo = new File("Empleados");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
		// ESCRIBIR EN EL FICHERO
		oos.writeObject(misEmpleados);
		oos.close();

		ArrayList<Empleado> datosArchivo = new ArrayList<Empleado>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
		// RECUPERAR Y LEER FICHERO
		datosArchivo = (ArrayList<Empleado>) ois.readObject();
		ois.close();
		// Comprobamos que el atributo clave es NULL
		for (Empleado e : datosArchivo) {
			System.out.println(e);
		}

	}

}
