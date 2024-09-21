package estructura_de_datos.iterators.IterablesAndIterators;

import java.util.ArrayList;
import java.util.Iterator;

public class AlumsGrup implements Iterable <Alum>{

  private String name;
  private ArrayList <Alum> alums;

  public AlumsGrup(String name){
    this.name = name;
    this.alums = new ArrayList<>();
  }

  public String getName(){
    return name;
  }

  public void addAlums(Alum a){
    alums.add(a);
  }

//  @Override
//  public Iterator < Alum > iterator () {
//    return alums.iterator ();
//  }
//


  @Override
  public Iterator <Alum> iterator(){
    return new Iterator <Alum>() {
      private int position = 0;

      @Override
      public boolean hasNext(){
        while ( ( position < alums.size() ) && ( alums.get(position).getName() == null ) || ( position < alums.size() ) && ( alums.get(position).getAge() == 0 ) ){
          position++;
        }
        return position < alums.size();
      }

      @Override
      public Alum next(){
        return alums.get(position++);
      }
    };
  }

}
