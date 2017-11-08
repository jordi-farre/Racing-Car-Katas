package tddmicroexercises.textconvertor

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source


class HtmlTextConverterTest  extends FlatSpec with Matchers {
  it should "scape html in each line of a file" in {
    val inputPath = this.getClass.getResource("input_with_html.txt").getPath;
    val expectedResult = Source.fromURL(this.getClass.getResource("output_with_escaped_html.txt")).getLines().mkString("\n")

    val converter = new HtmlTextConverter(inputPath);

    converter.convertToHtml() shouldEqual expectedResult
  }
}