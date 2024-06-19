package org.kurt.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.objectweb.asm.*;

/** */
public class BytecodeInspector {

  private static final Set<String> RESTRICTED_CLASSES = new HashSet<>();

  static {
    RESTRICTED_CLASSES.add("java/util/Arrays");
    RESTRICTED_CLASSES.add("java/util/Collections");
  }

  public static void inspectClassForRestrictedMethods(Class<?> clazz) {
    try {
      ClassReader reader = new ClassReader(clazz.getName());
      reader.accept(
          new ClassVisitor(Opcodes.ASM9) {
            @Override
            public MethodVisitor visitMethod(
                int access, String name, String descriptor, String signature, String[] exceptions) {
              return new MethodVisitor(Opcodes.ASM9) {
                @Override
                public void visitMethodInsn(
                    int opcode, String owner, String name, String descriptor, boolean isInterface) {
                  if (RESTRICTED_CLASSES.contains(owner)) {
                    throw new AssertionError(
                        String.format(
                            "Usage of restricted class detected in method: %s -> %s.%s",
                            name, owner, name));
                  }
                  super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                }
              };
            }
          },
          0);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read class bytecode", e);
    }
  }
}
