package estructura_de_datos.javaColectionFramework.Maps.treeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainAlum {

	public static void main(String[] args){

		Map <Alum, ArrayList <Double>> notesDam = new TreeMap <>();

		Alum a1 = new Alum("Pep", "0004", 20);
		Alum a2 = new Alum("Jhon", "0001", 30);
		Alum a3 = new Alum("Bill", "0009", 19);

		addGrade(notesDam, a1, 4.9 );
		addGrade(notesDam, a1, 4.6);
		addGrade(notesDam, a2, 3.2);
		addGrade(notesDam, a2, 2.9);
		addGrade(notesDam, a3, 2.6);
		addGrade(notesDam, a3, 2.7);

		System.out.println(notesDam);
		System.out.println("---------------------------");
		getAverageAllAlum(notesDam);
		System.out.println("---------------------------");
		getAveragePerAlum(notesDam, "Bill");

		System.out.println("###########################################################");
   // Maps anidados
		Map<Alum, Map<String, ArrayList<Double>>> alumGrades = new TreeMap<>();

		Alum a4 = new Alum("Mauricio", "00032", 39 );
		Alum a5 = new Alum("Esteban", "00019", 39 );
		Alum a6 = new Alum("Vélez", "00027", 39 );
		Alum a7 = new Alum("Solís", "0005", 39 );

		addGradePerModule(alumGrades, a4, "Chemistry", 3.3);
		addGradePerModule(alumGrades, a4, "Chemistry", 3.4);
		addGradePerModule(alumGrades, a4, "Physic", 4.3);
		addGradePerModule(alumGrades, a5, "Chemistry", 3.3);
		addGradePerModule(alumGrades, a6, "Physic", 4.3);
		addGradePerModule(alumGrades, a4, "Chemistry", 3.9);
		addGradePerModule(alumGrades, a7, "Physic", 3.0);

		System.out.println(alumGrades);

	}

	public static void addGrade(Map <Alum, ArrayList <Double>> notesDam, Alum a, Double grade){
		ArrayList <Double> grades = notesDam.getOrDefault(a, new ArrayList <>());
		grades.add(grade);
		notesDam.put(a, grades);
	}


	public static void getAverageAllAlum(Map<Alum, ArrayList <Double>> gradesDam){
		for ( Map.Entry <Alum, ArrayList <Double>> grades : gradesDam.entrySet()){
			ArrayList <Double> gradesPerAlum = grades.getValue();
			int count = 0;
			double grade = 0;
			for ( double n: gradesPerAlum ){
				grade += n;
				count++;
			}
			System.out.println(grades.getKey().getName()+"  --> All grades "+ gradesPerAlum +" --> Result grades = " +grade/count);
		}
	}

	public static void getAveragePerAlum (Map<Alum, ArrayList<Double>> gradesDam, String name){
		for ( Map.Entry<Alum, ArrayList<Double> > grades : gradesDam.entrySet() ){
			if(grades.getKey().getName() == name){
				int count = 0;
				double acum = 0;
				for ( double grade : grades.getValue() ){
					acum += grade;
					count++;
				}
				System.out.println( name+" --> grades: "+ grades.getValue()+ " Average of grades: "+ acum/count);
			}
		}
	}
	// Métodos para el Map anidado

	public static void addGradePerModule (Map<Alum, Map<String, ArrayList<Double>>> alumsGrades, Alum a, String module, double grade ){
		Map<String, ArrayList<Double>> alumGrade = alumsGrades.get(a);
		if(alumGrade == null){
			alumGrade = new HashMap <>();
			 alumsGrades.put(a, alumGrade);
		 }
		ArrayList<Double> alumModuleGrades = alumGrade.get(module);
		if( alumModuleGrades == null){
			alumModuleGrades = new ArrayList<>();
			alumGrade.put(module, alumModuleGrades);
		}
		alumModuleGrades.add(grade);

	}

}
