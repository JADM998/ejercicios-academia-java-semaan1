### Ejercicio de inyección de dependencias y polimorfismo

#### Polimorfismo

El ejercicio se encuentra en org.example.polimorfismo, se puede ejecutar desde Main.java. Existe el paquete `org.example.polimorfismo.Personal` donde se encuentran implementaciones para explicar el polimorfismo.

Existen 5 clases, aun que 2 de ellas son base de las demás, la jerarquía es:
1. Persona
2. Profesional
3. ProfesionalDesempleado - ProfesionalMedico - ProfesionalProframador

En el código se aplico polimorfismo de varias maneras:
1. La sobreescritura de los métodos, por ejemplo, `ProfesionalMedico` sobreescribio el método `trabajar` que heredo de la clase `Profesional`, añadiendo funcionalidad extra, de igual forma las otras clases `ProfesionalDesempleado` y `ProfesionalProgramador` realizaron lo mismo.
2. Algunos métodos tienen varias firmas, por ejemplo, en la clase `Persona` los métodos `caminar` y `correr` se acepta no tener parámetros y a la vez también un parámetro boolean para indicar información extra.
3. En `main` se uso la keyword `instaceof` y se casteo a tipos más especificos, sobretodo de `Persona` a `Profesional` y de `Profesional` se casteo a `ProfesionalMedico` y `ProfesionalProgramador`, lo que permitió llamar a métodos distintos. Además se llamaron métodos definidos en `Persona` desde una instancia de tipo `Profesioanl`.
4. Se estableció una clase base `Persona` a través de la instanciación de clases hijas.

#### Inyección de dependencias

El ejercicio se encuentra en `org.example.dependencias.pokemon` y se puede ejecutar desde el Main.java superior al paquete pokemon. En este ejercició se simuló combates Pokemon donde hay 4 clases principales.

1. `Pokemon`: Clase base que define el comportamiento y atributos de todos los pokemon.
2. `PokemonMove`: Clase base que define un solo movimiento pokemon y que es útil para manejar los datos y comportamientos de estos movimientos.
3. `PokemonCombat`: Clase que sirve como un servicio para combatir dos pokemon.
4. `PokemonStats`: Clase auxiliar que permite definir finamente las estadísticas de un pokemon.

En este ejercició se uso inyección de dependencias usando el método de construcción, ya que en `Main.java` se definieron los objetos necesarios para poder realizar los combates.

1. Se inició instanciando un arreglo de 4 movimientos pokemon, donde solo se llenaron 2 espacios para todos los objetos. También se definió las estadísticas de los pokemon, se uso inyección de dependencias al pasar estos objetos en los parámetros de construcción y así lograr desacolpar la creación de los objetos en las clases específicas.
2. Con `PokemonStats` y `PokemonMove` definidos se crearon instancias de `Pokemon` inyectando los anteriors objetos, logrando así la inyección de dependencias.
3. Se definieron 4 `Pokemon`, se necesita 2 para librar un combate por lo que se seleccionaron al azar y se inyectaron en `PokemonCombat`.
4. Todo lo demás es lógica para el control del combate.