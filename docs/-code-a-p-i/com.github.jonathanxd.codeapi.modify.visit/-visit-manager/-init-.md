[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.modify.visit](../index.md) / [VisitManager](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`VisitManager()`

Manager of visitor of part [T](#).

The implementation must care about [register](register.md) methods, these methods put values in [partVisitorMap](#),
that isn't accessible from the implementation, if you want to control the register behavior
override these methods.

The [getVisitor](get-visitor.md) method is always called to find a registered visitor.

