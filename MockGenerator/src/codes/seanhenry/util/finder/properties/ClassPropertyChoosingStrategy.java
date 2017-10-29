package codes.seanhenry.util.finder.properties;

import com.jetbrains.swift.psi.SwiftTypeDeclaration;
import com.jetbrains.swift.psi.SwiftVariableDeclaration;
import com.jetbrains.swift.psi.SwiftVisitor;
import com.jetbrains.swift.symbols.SwiftDeclarationSpecifiers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ClassPropertyChoosingStrategy implements PropertyChoosingStrategy {

  @Override
  public List<SwiftVariableDeclaration> chooseProperties(SwiftTypeDeclaration type) {
    ClassPropertyVisitor visitor = new ClassPropertyVisitor();
    type.acceptChildren(visitor);
    return visitor.properties;
  }

  private class ClassPropertyVisitor extends SwiftVisitor {

    private List<SwiftVariableDeclaration> properties = new ArrayList<>();

    @Override
    public void visitVariableDeclaration(@NotNull SwiftVariableDeclaration property) {
      super.visitVariableDeclaration(property);
      if (property.isConstant() || property.isStatic() || property.getAttributes().hasDeclarationSpecifier(SwiftDeclarationSpecifiers.FINAL)) {
        return;
      }
      properties.add(property);
    }
  }
}
