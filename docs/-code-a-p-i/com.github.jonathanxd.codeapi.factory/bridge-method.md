[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [bridgeMethod](.)

# bridgeMethod

`fun bridgeMethod(owner: `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`, current: `[`MethodDeclarationBase`](../com.github.jonathanxd.codeapi.base/-method-declaration-base/index.md)`, methodSpec: `[`MethodTypeSpec`](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): `[`MethodDeclaration`](../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)

Help with bridge method creation.

Obs: this code is a bit old but still working as intended.

### Parameters

`owner` - Owner of the method [current](bridge-method.md#com.github.jonathanxd.codeapi.factory$bridgeMethod(com.github.jonathanxd.codeapi.base.TypeDeclaration, com.github.jonathanxd.codeapi.base.MethodDeclarationBase, com.github.jonathanxd.codeapi.common.MethodTypeSpec)/current).

`current` - Method to bridge.

`methodSpec` - Specification of the erased method to bridge.