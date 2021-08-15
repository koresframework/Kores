//[Kores](../../../../index.md)/[com.koresframework.kores.processor](../../index.md)/[ValidationEnvironment](../index.md)/[Impl](index.md)/[enterSession](enter-session.md)

# enterSession

[jvm]\
open override fun [enterSession](enter-session.md)(): [ValidationEnvironment.Session](../-session/index.md)

Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation.

This is used to analyze messages of other validation processes without needing to rely on list size and sub-list, a new session keeps track of messages added after the invocation of this method and before the invocation of [exitSession](exit-session.md), but the list of messages does not have any relation with the list holden by [ValidationEnvironment](../index.md), values are added simultaneously to session and [ValidationEnvironment](../index.md).

The list provided by session is mutable.

Returns new session.
