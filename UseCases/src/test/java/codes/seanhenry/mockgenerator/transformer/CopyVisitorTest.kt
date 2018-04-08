package codes.seanhenry.mockgenerator.transformer

import codes.seanhenry.mockgenerator.ast.*
import junit.framework.TestCase

class CopyVisitorTest: TestCase() {

  fun testShouldCopy() {
    assertCopied(TypeIdentifier("Type"))
    assertCopied(FunctionType.Builder().build())
    assertCopied(OptionalType.Builder().build())
    assertCopied(BracketType(TypeIdentifier("Type")))
    assertCopied(ArrayType.Builder().build())
    assertCopied(DictionaryType.Builder().build())
    assertCopied(GenericType.Builder("Type").build())
  }

  private fun assertCopied(original: Type) {
    val copied = CopyVisitor.copy(original)
    assert(original !== copied)
    assert(original == copied)
  }
}
