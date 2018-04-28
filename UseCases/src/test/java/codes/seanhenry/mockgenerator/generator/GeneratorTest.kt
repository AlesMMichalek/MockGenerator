package codes.seanhenry.mockgenerator.generator

import codes.seanhenry.mockgenerator.generator.templates.protocol.*
import junit.framework.TestCase

class GeneratorTest : TestCase() {

  fun testMultipleProtocols() {
    runTest(MultipleProtocolTest())
  }

  fun testDiamondInheritanceProtocols() {
    runTest(DiamondInheritanceTest())
  }

  fun testMultipleOverloadingProtocols() {
    runTest(MultipleOverloadingProtocolsTest())
  }

  fun testRemovesDuplicatesFromOverriddenClasses() {
    runTest(ClassOverridingTest())
  }

  fun testMocksSuperclasses() {
    runTest(SuperclassTest())
  }

  fun testDeepProtocolInheritance() {
    runTest(DeepProtocolInheritanceTest())
  }

  private fun runTest(template: GeneratorTestTemplate) {
    val view = MustacheMockView()
    val generator = Generator(view)
    template.build(generator)
    generator.generate()
    assertEquals(template.getExpected(), view.rendered)
  }
}
