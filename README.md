**English Version Soon**

Plan:
- First Stable Release: 2.0

Plano:
- Primeira release estável: 2.0

# CodeAPI

Framework para geração de código-fonte Java e bytecode para JVM.

### Porque um Framework para isto?

A maioria dos geradores de códigos (bytecode e Java) só podem gerar um deles, bytecode ou código-fonte, a CodeAPI tenta uma outra abordagem, gerar código-fonte e bytecode, mas porque? Para que processadores possam gerar códigos-fonte em *tempo de compilação* e bytecode para *tempo de execução*. (Gerar código-fonte e compilar é muito lento.)

### CodeAPI comparado a outros Frameworks

A principal diferença do CodeAPI é sua capacidade de gerar códigos-fonte e a manipulação amigável ao programador Java. O projeto também tem o objetivo de facilitar ao máximo a geração de código-fonte e bytecode. CodeAPI futuramente também poderá traduzir bytecode e código-fonte para Instruções e facilitar a manipulação das instruções.


A geração de código-fonte da CodeAPI é feita pela tradução *plana* das instruções para texto, e a geração de bytecode é feita por meio do Framework [ASM](http://asm.ow2.org/).

### Recursos

**Recursos já implementados**

- Interfaces
- Classes
- Extends & Implements
- Fields
- Constructors
- Methods
- Method Invocation
- Arrays
- Primitive Types
- Values (String, Numbers, Null) **as Literals**
- Cast
- If-Else
- Try-Catch-Finally
- For, While, Do-While
- Static Blocks
- Mathematical Operations (Add, Subtract, Divide, Multiply, Remainder)
- Method Reference Lambdas
- Invoke Dynamic
- Geração de código-fonte
- Geração de bytecode

**Recursos planejados**

- Enumerações
- Anotações (Classe de Anotações e Anotações em elementos)
- Melhorias para a facilitar a identificação dos locais de erros (TagLine)
- All Lambdas (only Method Reference lambda is implemented yet)
- Opções para diferentes meios de gerações de códigos para determinadas instruções
- Suporte a genericos e generic type filling (Preenchimento de tipos genericos)
- Gerar instruções a partir do código-fonte
- Gerar instruções a partir do bytecode (.class)

### Criando sua primeira classe

##### Importações estaticas
```Java
import static com.github.jonathanxd.codeapi.CodeAPI.*;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.*;
import static java.lang.reflect.Modifier.*;
```

##### Criando uma classe
```Java

CodeSource source = source();
// Modificadores, Nome completo qualificado
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass");
// Adiciona a lista de instruções
source.add(myClass);

```

##### Criando uma classe com construtor
```Java
// Modificadores, Nome completo qualificado, Classe -> Código Fonte (código fonte da classe)
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass", codeClass -> sourceOfParts(
  // Modificadores, Classe que esta declarando o construtor
  constructor(PUBLIC, codeClass)
));
```

##### Imprimindo Olá mundo no construtor
```Java
// Modificadores, Nome completo qualificado, Classe -> Código Fonte (código fonte da classe)
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass", codeClass -> sourceOfParts(
  // Modificadores, Classe que esta declarando o construtor, Construtor -> Código Fonte (código fonte do construtor)
  constructor(PUBLIC, codeClass, codeConstructor -> sourceOfParts(
    // Alvo (Variavel, Metodo, Variavel, Field, etc...), Classe do metodo, Descrição do metodo (tipo de retorno, tipo dos argumentos), Argumentos
    // Ex:
    // List list = ...;
    // list.clear();
    //Alvo: 'list', Classe do metodo: 'List', Nome do metodo: 'clear', Descrição do metodo: 'VOID'
    invokeVirtual(
        // ALVO: Classe do Campo (Field), Tipo do campo, Nome do campo. Mesmo que: System.out
        accessStaticField(System.class, PrintStream.class, "out"),
        // Classe do metodo
        PrintStream.class,
        // Nome do metodo
        "println",
        // Descrição do metodo (Tipo De Retorno, Tipos dos argumentos...)
        new TypeSpec(VOID, STRING),
        // Argumentos (String Literal)      
        argument(Literals.STRING("Olá mundo!")))
  ))
));
```

##### Gerando código fonte

```Java
// Obtem a instancia do gerador de código fonte (O gerador de código-fonte é Singleton (Instancia Unica), isto será mudando quando implementar as 'Opções de geração de código')
PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;
// Gera o código fonte
String plainSource = plainSourceGenerator.gen(source);
```

**Imprimir codigo fonte**: `System.out.println(plainSource);`

##### Gerando bytecode
```Java
// Cria uma instancia do gerador de bytecode (Suporta Opções).
BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

// Gera o bytecode e obtem o resultado.
Byte[] bytecode = bytecodeGenerator.gen(source).getResult();
```

###### Carregando a classe
Class Loader:
```Java
private static final class BCLoader extends ClassLoader {

    protected BCLoader(ClassLoader parent) {
        super(parent);
    }

    public Class<?> define(CodeInterface codeInterface, byte[] bytes) {
        return super.defineClass(codeInterface.getQualifiedName(), bytes, 0, bytes.length);
    }
}
```

**Carregando classe & Chamando construtor**

```Java
// Converte a Array de Bytes Wrapper para primitivo.
// Metodo da library JwIUtils
byte[] bytes = PrimitiveArrayConverter.toPrimitive(bytecode);

// Cria instancia do class loader ligado ao class loader desta classe.
BCLoader bytecodeLoader = new BCLoader(this.getClass().getClassLoader());

// Carrega a classe
Class<?> cl = bytecodeLoader.define(myClass, bytes);

try {
  // Cria a instancia
  cl.newInstance();
} catch (Throwable t) { throw new RuntimeException(t); }

```

**Saida**:
Código-Fonte:
```Java
package mypackage ; public class MyClass { public MyClass ( ) { java.lang.System . out . println ( "Olá mundo!" ) ; } }
```
Bytecode:
`Olá mundo!`

### Boxing e Unboxing

CodeAPI pode fazer boxing e unboxing se souber quais tipos converter

Método `Helper.cast(de, para, parteParaCastear)`


Exemplo:

`Helper.cast(INTEGER_TYPE, INT, invokeVirtual(accessLocalVariable(MyClass.class, "myClassInstance"), MyClass.class, "getNumber", new TypeSpec(INTEGER_TYPE)))`

Isto irá fazer unboxing do retorno de `Integer myClassInstance.getNumber()` para `int`.

### Limitações

- CodeAPI não formata códigos-fonte.
- Nem todos elementos foram implementados nos dois geradores (código-fonte & bytecode)
- Algumas instruções podem funcionar somente na geração de códigos-fonte e outras somente na geração de bytecode (invoke dynamic).
- Erros na definição de instruções são dificeis de identificar pois a CodeAPI gera códigos por meio do processamento da estrutra.

##### Geração de código fonte vs Geração de bytecode

Recursos suportados somente pela geração de código-fonte:

- Classes dentro de classes (inner classes)
- Expressões livres (expression(NEW, ...))
- Variaveis com o mesmo nome em diferentes blocos de código (`try { String value; } catch(Exception e){} String value;`).

Recursos suportados somente pela geração de Bytecode:

- Sobrecarregar tipos de retornos
- Sobrecarregar tipos de campos (fields)
- Sobrecarregar tipos de Variaveis locais
- Chamar metodos com exceções verificadas sem um try-catch-block.
- Nomes reservados como nomes de elementos. (Metodos, Campos (fields), Variaveis)
- Bootstrap InvokeDyanmic (irei explicar futuramente).

##### Limitações do gerator de Bytecode

O gerador de bytecode não pode:

- Gerar nomes de variaveis locais (Os nomes de variaveis (e tipos) são armazenadas em `common.MVData` durante a geração do bytecode para obter a posição das variaveis na stack.)
- Gerar variaveis locais com nomes e tipos iguais em diferentes blocos de tipos (por exemplo, uma `String value` dentro do Try-Catch-Block e a mesma variavel fora do Try-Catch-Block, exemplo: `try { String value; } catch(Exception e){} String value;`).
- Gerar ifs complexos (`if(x || y && (u && (i || v)))`), no momento, somente if's basicos são suportados, tipo: `x || y, y && x || z` (voce pode adotar estrategias para driblar isto).


### Desempenho gerar código-fonte vs gerar bytecode

A geração de código fonte é aproximadamente 25% mais lento que a geração de bytecode, primeiramente devido a forma qual é implementado, e por utilizar mais processos para gerar o código fonte, enquanto o gerador de bytecode tem 34 classes para geração das instruções, o gerador de código-fonte tem 46 classes.

### Meio utiizado para gerar os códigos

O gerador de bytecode utiliza visitas recursivas, talvez seja mudado para se adaptar melhor a forma qual o ASM funciona.

O gerador de código-fonte utiliza processamento de valores.

As classes do gerador de bytecode geram diretamente as instruções em bytecode, o gerador de código-fonte informa o núcleo (Generator) o que ele precisa fazer, e ele se encarrega da geração.
