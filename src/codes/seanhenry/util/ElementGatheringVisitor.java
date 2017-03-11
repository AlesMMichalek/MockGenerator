/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package codes.seanhenry.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementVisitor;

import java.util.ArrayList;
import java.util.List;

public class ElementGatheringVisitor<T extends PsiElement> extends PsiRecursiveElementVisitor {

  private Class<T> type;
  private ArrayList<T> elements = new ArrayList<>();

  public ElementGatheringVisitor(Class<T> type) {
    this.type = type;
  }

  @Override
  public void visitElement(PsiElement element) {
    if (type.isInstance(element)) {
      elements.add((T) element);
    }
    super.visitElement(element);
  }

  public List<T> getElements() {
    return elements;
  }
}
