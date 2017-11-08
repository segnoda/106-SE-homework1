JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
		  PhoneBookController.java \
		  PhoneBookModel.java \
		  PhoneBookView.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
