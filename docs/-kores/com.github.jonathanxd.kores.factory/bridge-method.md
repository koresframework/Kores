//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[bridgeMethod](bridge-method.md)

# bridgeMethod

[jvm]\
fun [bridgeMethod](bridge-method.md)(owner: [TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md), current: [MethodDeclarationBase](../com.github.jonathanxd.kores.base/-method-declaration-base/index.md), methodSpec: [MethodTypeSpec](../com.github.jonathanxd.kores.common/-method-type-spec/index.md)): [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md)

Help with bridge method creation.

Obs: this code is a bit old but still working as intended.

## Parameters

jvm

| | |
|---|---|
| owner | Owner of the method [current](bridge-method.md). |
| current | Method to bridge. |
| methodSpec | Specification of the erased method to bridge. |
