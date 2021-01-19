public class Rule {
        private char symbol;
        private String sequence;

        public Rule(char symbol , String sequence){
            this.symbol = symbol;
            this.sequence = sequence;
        }

        public char getSymbol() {
            return symbol;
        }

        public String getSequence() {
            return sequence;
        }

}
