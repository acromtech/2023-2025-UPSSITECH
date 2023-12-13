CXX = g++
CXXFLAGS = -std=c++11 -Wall

all: main

main: main.o Document.o Livre.o Article.o Biblio.o
	$(CXX) $(CXXFLAGS) -o main main.o Document.o Livre.o Article.o Biblio.o

main.o: main.cpp Document.h Livre.h Article.h Biblio.h
	$(CXX) $(CXXFLAGS) -c main.cpp

Document.o: Document.cpp Document.h
	$(CXX) $(CXXFLAGS) -c Document.cpp

Livre.o: Livre.cpp Livre.h Document.h
	$(CXX) $(CXXFLAGS) -c Livre.cpp

Article.o: Article.cpp Article.h Document.h
	$(CXX) $(CXXFLAGS) -c Article.cpp

Biblio.o: Biblio.cpp Biblio.h Document.h
	$(CXX) $(CXXFLAGS) -c Biblio.cpp

clean:
	rm -f main main.o Document.o Livre.o Article.o Biblio.o
