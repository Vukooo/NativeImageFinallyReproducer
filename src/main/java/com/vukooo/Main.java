package com.vukooo;

import org.objectweb.asm.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.objectweb.asm.Opcodes.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        new File("generated/org/example/").mkdirs();
        Files.write(Paths.get("generated/org/example/Main.class"), dumpMain());
        Files.write(Paths.get("generated/org/example/TryFinalTest.class"), dumpTryFinalTest());
    }

    public static byte[] dumpMain() {

        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;

        classWriter.visit(V11, ACC_PUBLIC, "org/example/Main", null, "java/lang/Object", null);

        classWriter.visitSource("SourceFile", null);

        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "closeQuiet", "(Ljava/io/Closeable;)V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label1, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            Label label2 = new Label();
            methodVisitor.visitJumpInsn(IFNULL, label2);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "java/io/Closeable", "close", "()V", true);
            methodVisitor.visitJumpInsn(GOTO, label2);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitFrame(Opcodes.F_NEW, 0, new Object[]{}, 1, new Object[]{"java/lang/Throwable"});
            methodVisitor.visitInsn(POP);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(Opcodes.F_NEW, 0, new Object[]{}, 0, new Object[]{});
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            methodVisitor.visitCode();
            methodVisitor.visitTypeInsn(NEW, "java/util/zip/ZipFile");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitLdcInsn("");
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/util/zip/ZipFile", "<init>", "(Ljava/lang/String;)V", false);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "org/example/Main", "closeQuiet", "(Ljava/io/Closeable;)V", false);
            methodVisitor.visitTypeInsn(NEW, "org/example/TryFinalTest");
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "org/example/TryFinalTest", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(3, 1);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }

    public static byte[] dumpTryFinalTest() {


        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;

        classWriter.visit(V11, ACC_PUBLIC | ACC_FINAL, "org/example/TryFinalTest", null, "java/lang/Object", null);

        classWriter.visitSource("SourceFile", null);

        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, null);
            Label label3 = new Label();
            Label label4 = new Label();
            methodVisitor.visitTryCatchBlock(label3, label4, label2, null);
            Label label5 = new Label();
            Label label6 = new Label();
            methodVisitor.visitTryCatchBlock(label4, label5, label6, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(ACONST_NULL);
            methodVisitor.visitVarInsn(ASTORE, 1);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitTypeInsn(NEW, "java/io/ByteArrayInputStream");
            methodVisitor.visitLabel(label1);
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitVarInsn(ASTORE, 2);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitIntInsn(NEWARRAY, T_BYTE);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/io/ByteArrayInputStream", "<init>", "([B)V", false);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitFrame(Opcodes.F_NEW, 3, new Object[]{"org/example/TryFinalTest", Opcodes.TOP, "java/io/ByteArrayInputStream"}, 0, new Object[]{});
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/ByteArrayInputStream", "markSupported", "()Z", false);
            methodVisitor.visitLabel(label5);
            Label label7 = new Label();
            methodVisitor.visitJumpInsn(IFEQ, label7);
            methodVisitor.visitJumpInsn(GOTO, label4);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitFrame(Opcodes.F_NEW, 3, new Object[]{Opcodes.TOP, Opcodes.TOP, "java/io/ByteArrayInputStream"}, 0, new Object[]{});
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "org/example/Main", "closeQuiet", "(Ljava/io/Closeable;)V", false);
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitLabel(label6);
            methodVisitor.visitFrame(Opcodes.F_NEW, 3, new Object[]{"org/example/TryFinalTest", Opcodes.TOP, "java/io/ByteArrayInputStream"}, 1, new Object[]{"java/lang/Throwable"});
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ASTORE, 1);
            methodVisitor.visitJumpInsn(GOTO, label2);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitFrame(Opcodes.F_NEW, 2, new Object[]{"org/example/TryFinalTest", "java/io/ByteArrayInputStream"}, 1, new Object[]{"java/lang/Throwable"});
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKESTATIC, "org/example/Main", "closeQuiet", "(Ljava/io/Closeable;)V", false);
            methodVisitor.visitInsn(ATHROW);
            methodVisitor.visitMaxs(2, 3);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }


}