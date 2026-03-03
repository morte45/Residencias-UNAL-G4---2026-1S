# Residencias-UNAL-G4---2026-1S
La Universidad Nacional de Colombia desea implementar un sistema para la gestión de sus residencias universitarias para aquellos estudiantes que necesitan alojamiento en cercanías a la universidad durante su tiempo de estudios. No obstante, los cupos son limitados y se presenta una alta demanda de solicitudes que deben ser atendidas de manera imparcial, eficiente y dinámica. El sistema que se desea implementar debe permitir el registro de estudiantes con ciertos atributos claves como ID, Nombre completo y puntaje socioeconómico. Adicionalmente, el sistema debe poder llevar a cabo ciertas operaciones que apoyaran en la asignación de cupos, dichas operaciones son:

- Ingreso de cantidad de cupos disponibles
- Acceder a los datos del estudiante por ID
- Listar estudiantes en el sistema
- Ordenar en orden decreciente a los estudiantes por puntaje socioeconómico
- Asignación de cupos, empezando por los estudiantes de puntajes más bajos
- Listar estudiantes que obtuvieron residencia y aquellos que no
- Modificar el puntaje de un estudiante 
- Eliminar estudiantes del sistema

Para el proyecto se usarán arboles AVL que estará ordenado por el puntaje socioeconómico, esto justifica recordando que la asignación de cupos será determinada por el estudiante que tenga el menor puntaje socioeconómico, para este fin se precisa la rápida identificación de dicho estudiante, gracias a este tipo de estructura de datos dicho dato siempre estará al extremo izquierdo del árbol y los demás irán ordenados por su puntaje, consecutivamente. Sin embargo, surge un problema a la hora de realizar una búsqueda por ID, en vista que el árbol está ordenado por puntaje y no por ID, la complejidad de busqueda por ID seria (O(n)), la cual a grandes rasgos nos conlleva a tiempos de ejecución lentos, no obstante, para solucionar este problema podríamos implementar una estructura adicional, en este caso los arreglos nos permiten realizar búsquedas binarias, complejidad logarítmica O(log n); esto resulta en una solución ideal para la búsqueda por ID único.


Lenguajes de programación usados: **Java (versión 25)**

Integrantes del grupo:
- Sergio Bohórquez Alfonso
- Diego Andrés Rodríguez Cuarán
- Heyder Andres Carlosama Hernandez
- Miguel Angel Amortegui Enciso
- Edgar Mauricio Gonzalez Yaya
