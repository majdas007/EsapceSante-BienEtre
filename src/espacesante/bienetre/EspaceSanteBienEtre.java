/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;

import Entite.CategorieForum;
import Entite.Question;
import Entite.Reponse;
import Utils.ConnexionBD;
import Service.QuestionService;
import Service.ReponseService;
import Service.ServiceCategorieForum;
import java.util.List;

/**
 *
 * @author majd
 */
public class EspaceSanteBienEtre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
    
// Question p2 = new Question(2,"quelle est le nom de maladie");
// Question p3= new Question(3,"g une question ");
//Question p6 = new Question(25," mardi ++ ");
//
//  QuestionService.getInstance().DeleteQuestion(p6);
  
  //QuestionService.getInstance().AddQuestion(p6);
   
//       
// Reponse p = new Reponse (" je pense que c la crooection") ;
// Reponse p1 =new Reponse (" faux ou vrai  ? ") ;
// //ReponseService.getInstance().AddReponse(p);
// //ReponseService.getInstance().AddReponse(p1);
// //ReponseService.getInstance().ReadQuestion();
//       p.setContenu_rep(" c le changement");
// ReponseService.getInstance().UpdateReponse(p, 4);
   
       // ReponseService.getInstance().DeleteReponse(p1);
       
//  CategorieForum c = new CategorieForum("dentaire")    ;
//        ServiceCategorieForum.getInstance().AddCategorie(c);
//        Question q = new Question(15,"g mal au dents");
//        QuestionService.getInstance().AddQuestion(q);
        QuestionService.getInstance().FilterByCat(3);







        
    }
    
}
