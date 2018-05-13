Informe sobre el proyecto fibo3
===============================

¿cumple con la consigna fibo3?
¿tiene suficientes tests?
¿respeta la convenciones Java?
¿respeta los principio SOLID? en caso que no los respete indique que principio viola y porque?

El proyecto fibo3 otorgado no cumple con la consigna de impresión horizontal por consola, porque cuando imprime de forma horizontal no hace un salto de línea. Se ve la serie (la cual es correcta) pero además de dicha impresión vemos la ubicación en la que estamos parados en la consola. 
Respecto de los test sólo hay dos, considero que no son lo suficiente. Existen más clases con otros comportamientos (con lógica dentro) que no están siendo evaluadas. Si bien hay muchos más métodos de “prueba” estos no poseen Assert, entonces no evalúa valores esperados. Sino que hace llamados al método principal y eso no es garantía de que el test haya pasado satisfactoriamente. Si lo que se pretende con ello es evaluar la impresión por consola, eso implica que por cada vez que ejecute esa clase de prueba uno deberá chequear de forma manual cada impresión. Esto claramente no son pruebas  automatizadas. Pone en evidencia la falta de uso de TDD. (Y el nombre de la clase de prueba no debería tener el siguiente patrón testFibo3 ¿qué significado tiene esa numeración que hace? Considero que ninguna aplicación).

En respuesta a ¿si respeta convenciones Java? Definitivamente no. No respeta los estándares básicos de codificación en Java. Se detalla y se explicarán los porqués.
Las clases definidas no pueden tener la primera letra en minúscula, debe seguir el estilo “Camel Case”. Y aquí no lo sigue como por ejemplo, las clases con nombre: fibo, arregloDeNumeros, opcionM, entre otras. Además se puede observar que los nombres no son claros, simples ni descriptivos. Se podría llegar a comprender el nombre fibo al cual uno sabe a lo que hace referencia pero no. No es una buena práctica el uso de abreviaciones y/o acrónimos (salvo algunas excepciones) Dado que esto impactaría directamente en la cohesión. Como así tampoco los nombres de variables, parámetros, etc. No tiene una representación del dominio del problema, sus clases no reflejan lo que verdaderamente realizan. 
Otro tema y no menor es la indentación, la cual no sigue lógica. Se ven saltos de líneas cuando se está haciendo uso de la estructura de control condicional else if. Existe mucha rusticidad en la implementación, no utiliza polimorfismo entonces hace uso y abuso del operador condicional if por doquier.
Hay imports sin uso por ende son warning en el proyecto. Además de este warning hay otro pero es de una clase con nombre LongitudDos. Está clase tampoco respeta el primer principio de responsabilidad única, ya que tiene un método de impresión y otra operación que no es imprimir. Por ende tiene doble responsabilidad, la otra operación sencillamente se podría trasladar a dónde lo considere. 

En cuanto a tema validación, no maneja excepciones propias sino que ante cualquier excepción hace uso de la clase base Exception, lanzando por consola el mensaje “Opciones no validas.”. Es decir, que puede fallar por cuestiones lógicas de código y aún así mostrar un mensaje que no es el que corresponde. A su vez el hecho de trabajar con excepciones abstractas complica obtener la raíz del problema ocasionado.

Por último y el punto más relevante es respecto a los principios SOLID. Este proyecto no los respeta. 
El primer principio de Responsabilidad única “S”. No es respetado.
El núcleo del negocio, es decir la lógica de obtener la serie de Fibonacci se encuentra dispersa, o sea que existe una redundancia de la implementación. Pero bien adentrándonos al principio se ve que la clase encargada de esto es arregloDeNumeros su nombre no es claro puede interpretarse como arregladora y/o reparadora de números -tal y como lo indica su nombre-, o que trabajará con un array de números. De todas formas su diseño no es claro, tiene una baja cohesión. Si bien tiene una única responsabilidad porque vemos el único comportamiento con nombre obtenerArregloDeNumerosDeFibonacci su nombre (el de la clase) no lo estaría representando. 
Segundo principio de Abierto Cerrado “O”. No es respetado
Las clases generadas están abiertas para las modificaciones como ser opcionO y fibo (clase principal), están cargadas con condicionales. Estos realizan acciones según el parámetro indique. Por ende en este caso hacen lo contrario al principio, se abren para la modificación porque no se define qué es y hace, y en cierta forma se cierran para la extensión porque es difícil determinar quién “es un” cuando no es clara su interfaz.
Cuarto principio Segregación de la interfaz “I” 
La interfaz opcionO tiene mucha lógica y redundancia. Además que no tiene una única responsabilidad, este tema está más bien ligado al primer principio. No define interfaces finas. Este claro ejemplo de opcionO nos muestra la famosa y no grata “interfaz manager”.
(Otro tema que surge en esta clase, es que tiene métodos que reciben un String que tiene como nombre opcionO mismo nombre que la clase. Esto puede ser causa de problemas porque obligas a chequear si se habla del String o de la clase).

Conclusión: No es una porción de software sólida.

