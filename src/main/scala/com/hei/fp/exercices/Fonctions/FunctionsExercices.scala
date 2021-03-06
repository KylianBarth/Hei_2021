package com.hei.fp.exercices.Fonctions

// Tiré de Scala par l'exemple Martin Odersky

// A comment!
/* Another comment */
/**
 * A documentation comment
 * */


class FunctionsExercices {

  var x = 12 // variable mutable
  val y = 14 // valeur immutable - y sera évalué à l'execution, une fois pour toutes.
  def z = 14 // la partie droite sera évaluée lors de l'appel de z.

  // ---------------------------------------------- //
  /*                Les paramètres                  */
  // ---------------------------------------------- //
  def square(x : Double) : Double = x * x
  // square: (x: Double)Double
  // scala> square(2)
  // res0: Double = 4.0
  // scala> square(5 + 3)
  // res1: Double = 64.0
  // scala> square(square(4))
  // res2: Double = 256.0

  /**
   * Write a val function with parameters
   */
  val s = (x:Int) => x + 1

  /**
   * @param x : Int
   * @return x + 1
   */
  def addOne(x:Int) : Int = x + 1

  /**
   * define and test a function for x : int
   * @param x
   * @return x au cube
   */
  def cube(x:Int) : Int = x * x * x

  // todo Write and test a function that returns x^2 + y^2 and test it with 3 , 2+2
  /**
   *
   * @param x
   * @param y
   * @return
   */
  def sumOfSquaresOne (x: Double, y: Double) = x * x +y * y


  // ---------------------------------------------- //
  /*     Expressions conditionnelles : if - else    */
  // ---------------------------------------------- //
  // todo
  //  Write a function that return the absolute value of a double
  //  write the test first
  /**
   *
   * @param x
   * @return
   */
  def abs(x: Double) = ???

  // ---------------------------------------------- //
  /*         Call by name - call by value           */
  // ---------------------------------------------- //

  def loop : Int = loop
  //  loop: Int
  def first(x: Int, y: Int) = x
  // ----- Call by value => first(1,loop) = execution infinie
  // first: (x: Int, y: Int)Int
  def first(x: Int, y: => Int) = x
  // ---- Call by name => first(1,loop)    res0: Int = 1

  // ---------------------------------------------- //
  /*               Anonymous function               */
  // ---------------------------------------------- //
  (1 to 5).map( x => x * 1)
  ///(x: Int, y: Int) => x + y

  /**
   * Define and test a function take a integer and a function taking int & return Int with
   * // test it with anonymous function : f(x) = x + 2
   * @param x
   * @return  : x + f(x)
   */
  def addAnonymousToInt(x : Int, f:(Int) => Int ) : Int = x + f(x)

  // todo work on the array of list & functions applied
  val numbers = Array(Array(1,2,3,4,5),
    Array(6,7,8,9,10),
    Array.fill(10)(2))

  // todo write a function that takes as parameter :
  //  - an object of Type [T]
  //  - a function that returns an object of Type [T]
  //  - return an objet [T]
  /**
   *
   * @param xs
   * @param f
   * @return
   */
  def operation(xs : Array[Int], f :(Int) => Int) : Array[Int] = ???

  def printOperations : Unit = ???

  // ---------------------------------------------- //
  /*                 Recursivité                    */
  // ---------------------------------------------- //

  // Fonction qui fait appel à elle-même
  // todo Write and test a function return the factorial value of an integer
  /**
   *
   * @param n
   * @return
   */
  def factorielle(n : Int) : Int =
    if (n == 1) 1
    else n * factorielle(n-1)

  // ------------------------------------------------------ //
  /*            Fonctions imbriquées :                      */
  /* Calcul des la racine carrée par la méthode de Newton   */
  // ------------------------------------------------------ //

  // Objectif : définir la fonction
  // def sqrt(x:Double) : Double = ???
  // Algorithme y = sqrt(x)
  // On part d'une approximation de y => par exemple y  = 1 pour la racine carrée de 2
  // Puis on améliore à chaque itération en prenant la valeur (nouvelle estimation) de (y + x/y)/2
  //  y     x/y       (y + x/y)/2
  //  1     2/1        1.5
  //  1.5   2/1.5      1.4167    ....

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)
  }

  val e : Double = 0.001
  def improve(guess: Double, x: Double) : Double = ???
  def isGoodEnough(guess: Double, x: Double): Boolean = ???

  def sqrt(x: Double) = ???

  // todo rewrite the function sqrt(x) with only one block -  What about the parameters ? Can we simplify ?
  def sqrt = ???

  // ------------------------------------------------------ //
  /*                 recursivité terminale                  */
  // ------------------------------------------------------ //
  def gcd(a :Int, b : Int) : Int = {
    if (b == 0 ) a
    else gcd(b, a % b)
  }

  // -> todo compare with the last factorielle formulation

  // -> todo write a tailrec factorielle function

  def fact(acc : Int, n : Int) : Int = {
    if (???) ???
    else ???
  }

  // todo write a sum function using foldLeft methode
  /**
   *
   * @param l :
   * @return :
   */
  def foldSum(l : List[Int]) = ???

  // ---------------------------------------------- //
  /*             fonctions du premier ordre         */
  // ---------------------------------------------- //

  // Les fonctions qui prennent en paramètres d’autres fonctions
  // ou qui les renvoient comme résultat sont appelées fonction du premier ordre

  // todo ecrire une fonction additionnant tous les entiers compris entre deux bornes a et b :
  /**
   * hint linear reccursive
   * @param a
   * @param b
   * @return
   */
  def sumInts(a: Int, b: Int): Int =
    if (???) ??? else ???

  // todo   Écrire une fonction additionnant les carrés de tous les entiers compris entre deux bornes a et b:
  def square(x: Int): Int = x * x   // nb : surcharge de la function square avec un type Int

  def sumSquares(a: Int, b: Int): Int =
    if (???) ??? else ???


  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  // todo Écrire une fonction additionnant les puissances de 2 de tous les entiers compris entre deux bornes a et b :
  def sumPowersOfTwo(a: Int, b: Int): Int =
    if (???) ??? else ???

  // Ces fonctions étant toutes des instances de "Somme de f(n) pour n variant de a à b",
  // nous pouvons mettre ce motif commun en facteur en définissant une fonction sum :
  // Le type Int => Int est celui des fonctions qui prennent un paramètre de type Int et qui renvoient un résultat de type Int.
  // sum est donc une fonction qui prend en paramètre une autre fonction – c’est une fonction du premier ordre.
  // Grâce à elle, nous pouvons reformuler nos trois fonctions précédentes de la façon suivante :
  //  avec :

  def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)
  // avec
  def id(x: Int) : Int = x
  // todo réécrire les fonctions sumInts, sumSquares, sumPowersOfTwo
  // todo écrire les tests correspondants
  //def sumInts(a: Int, b: Int): Int = ???
  //def sumSquares(a: Int, b: Int): Int = ???
  //def sumPowersOfTwo(a: Int, b: Int): Int = ???

  // ---------------------------------------------- //
  /*             fonctions anonymes                 */
  // ---------------------------------------------- //

  // fonction définie sans qu'on lui donne un nom
  // (x : Int) => x * x
  // (x : Int, y : Int) => x * y

  // todo reformuler sumInts et sumSquares à l'aide fonction anonymes
  //def sumInts(a: Int, b: Int): Int = ???
  //def sumSquare(a: Int, b: Int): Int = ???

  // ---------------------------------------------- //
  /*                   Currying                     */
  // ---------------------------------------------- //

  // a et b apparaissent comme paramètres mais sont statiques
  // comment s'en débarasser ?
  def sum(f : Int => Int) : (Int, Int) => Int = {
    def sumF(a: Int, b: Int) : Int =
      if(a>b) 0 else f(a) + sumF(a+1 , b)
    sumF
  }

  // On peut donc maintenant écrire
  // def sumInts = ???
  // def sumSquares = ???
  // def sumPowersOfTwo = ???

  // formulation équivalente mais plus courte
  // def sum(f : Int => Int) (a :Int,b : Int) : Int =
  //    if (a > b) 0 else f(a) + sum(f)(a+1,b)

  // todo calculer la somme des carrées des nombres compris entre 1 et 10 + la somme des puissances de 2 pour les chiffres compris entre 10 et 20

  // ---------------------------------------------- //
  /*                   Exercices                    */
  // ---------------------------------------------- //

  // todo écrire une version récursive terminale de la fonction sum
  def sumTwo(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if (???) ???
      else iter(???, ???)
    }
    iter(???, ???)
  }

  // todo La somme des carrés des dix premiers nombres naturels est,
  //  1^2 + 2^2 + 3^2 + ... + 10^2  = 385
  //  Le carré de la somme des dix premiers nombres naturels est,
  //  (1+2+3+ ... + 10)^2 = 3025
  //  Ainsi, la différence entre la somme des carrés des dix premiers nombres naturels et le carré de la somme est
  //  3025 − 385 = 2640
  //  => Trouvez la différence entre la somme des carrés des cent premiers entier naturels et le carré de leur somme.



}
