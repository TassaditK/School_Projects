import java.util.ArrayList;

public class SetOfRules {
    private  Rule[] rules;


    public SetOfRules(Rule[] rules){
        this.rules = rules;
    }

    public  String apply(String sequence){
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i <sequence.length() ; i++) {
            String remplacerSeqence=Character.toString(sequence.charAt(i));
            for(Rule rule :rules){
                if(rule.getSymbol()==sequence.charAt(i)){
                    remplacerSeqence=rule.getSequence();
                    break;
                }
            }
            builder.append(remplacerSeqence);
        }



        return builder.toString() ;
    }

}
