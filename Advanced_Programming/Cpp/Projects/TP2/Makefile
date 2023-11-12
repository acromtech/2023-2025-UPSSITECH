CXX = g++
CXXFLAGS = -std=c++11 -Wall
EXEC = agenda_test

SRCS = main.cpp Entree.cpp Tableau.cpp Agenda.cpp
OBJS = $(SRCS:.cpp=.o)

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CXX) $(OBJS) -o $(EXEC)
	rm -f $(OBJS)
	./$(EXEC)

%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

clean:
	rm -f $(OBJS) $(EXEC)
