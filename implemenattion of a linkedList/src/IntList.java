public interface IntList  {

        /** @return la tête (le premier élément) de la liste si elle est non-vide
         */
        Cell getHead();
        /** @return la queue de la liste si elle est non-vide
         */
        IntList getTail();
        /** @return vrai si la liste est vide et faux sinon
         */
        boolean isEmpty();
        /** @param n l’entier à ajouter dans la liste
         * @return la liste à laquelle n est ajoutée
         */
        IntList cons(int n);
        /** @return la longueur de la liste
         */
        int length();

        /** @return la somme des elments de la liste
         */
        int sum();

        /**@param intList la liste avec laquelle on fait la comparaison
         * @return vrai si les deux listes sont égales et faux sinon
         */
        boolean equals(IntList intList);


}
