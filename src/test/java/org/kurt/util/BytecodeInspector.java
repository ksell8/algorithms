package org.kurt.util;

import org.objectweb.asm.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class BytecodeInspector {

  private static final Set<String> RESTRICTED_METHODS = new HashSet<>();

  static {
    RESTRICTED_METHODS.add("java/util/Arrays.sort");
    RESTRICTED_METHODS.add("java/util/Collections.binarySearch");
  }

  public static void inspectClassForRestrictedMethods(Class<?> clazz) {
    try {
      ClassReader reader = new ClassReader(clazz.getName());
      reader.accept(new ClassVisitor(Opcodes.ASM9) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
          return new MethodVisitor(Opcodes.ASM9) {
            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
              String methodSignature = String.format("%s, %s",owner,name);
              if (RESTRICTED_METHODS.contains(methodSignature)) {
                throw new AssertionError(String.format("Usage of restricted method detected in method: %s -> %s",
                        name,
                        methodSignature));
              }
              super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
            }
          };
        }
      }, 0);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read class bytecode", e);
    }
  }
}
