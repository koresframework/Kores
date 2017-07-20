[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ModuleDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`ModuleDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ModuleDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [exports](exports.md) | `var exports: List<`[`Export`](../../-export/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [provides](provides.md) | `var provides: List<`[`Provide`](../../-provide/index.md)`>` |
| [requires](requires.md) | `var requires: List<`[`Require`](../../-require/index.md)`>` |
| [uses](uses.md) | `var uses: List<`[`ModuleReference`](../../-module-reference/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ModuleDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [exports](exports.md) | `fun exports(value: List<`[`Export`](../../-export/index.md)`>): Builder`<br>`fun exports(vararg values: `[`Export`](../../-export/index.md)`): Builder`<br>`fun exports(vararg values: String): Builder`<br>See [ModuleDeclaration.exports](../exports.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [provides](provides.md) | `fun provides(value: List<`[`Provide`](../../-provide/index.md)`>): Builder`<br>`fun provides(vararg values: `[`Provide`](../../-provide/index.md)`): Builder`<br>`fun provides(vararg values: <ERROR CLASS><`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [ModuleDeclaration.provides](../provides.md) |
| [requires](requires.md) | `fun requires(value: List<`[`Require`](../../-require/index.md)`>): Builder`<br>`fun requires(vararg values: `[`Require`](../../-require/index.md)`): Builder`<br>`fun requires(vararg values: String): Builder`<br>See [ModuleDeclaration.requires](../requires.md) |
| [uses](uses.md) | `fun uses(value: List<`[`ModuleReference`](../../-module-reference/index.md)`>): Builder`<br>`fun uses(vararg values: `[`ModuleReference`](../../-module-reference/index.md)`): Builder`<br>`fun uses(vararg values: String): Builder`<br>See [ModuleDeclaration.uses](../uses.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ModuleDeclaration`](../index.md)`): Builder` |
