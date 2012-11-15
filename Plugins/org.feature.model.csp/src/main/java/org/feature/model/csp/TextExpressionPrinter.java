package org.feature.model.csp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.resource.expression.IExpressionTextPrinter;
import org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation;



public class TextExpressionPrinter {

   public static String printExpression(Term term) throws IOException{
      ExpressionMetaInformation metaInfo = new ExpressionMetaInformation();
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      IExpressionTextPrinter printer = metaInfo.createPrinter(outputStream, null);
      printer.print(term);
      return outputStream.toString();
   }
   
}
