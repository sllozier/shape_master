# Define Java compiler
JCC = javac

# Define Java compiler
JCC = javac

# Define Java runtime
JVM = java

# Specify the source, documentation, and bin directories
SRC_DIR = src/main
TEST_DIR = src/test
DOC_DIR = docs
BIN_DIR = bin
LIB_DIR = lib




# Java source files
SOURCES = $(SRC_DIR)/DrawingPanel.java \
		  $(SRC_DIR)/DrawableShape.java \
		  $(SRC_DIR)/Scene.java \
		  $(SRC_DIR)/Shape.java\
		  $(SRC_DIR)/TwoDimensionalShape.java\
		  $(SRC_DIR)/ThreeDimensionalShape.java\
		  $(SRC_DIR)/Circle.java\
		  $(SRC_DIR)/Square.java\
		  $(SRC_DIR)/Triangle.java\
		  $(SRC_DIR)/Rectangle.java\
		  $(SRC_DIR)/InvalidEntryException.java\
		  $(SRC_DIR)/Project1.java\
		  $(SRC_DIR)/Sphere.java\
		  $(SRC_DIR)/Cube.java\
		  $(SRC_DIR)/Cone.java\
		  $(SRC_DIR)/Cylinder.java\
		  $(SRC_DIR)/Torus.java\
		  $(TEST_DIR)/GenerateTestFile.java\
          $(TEST_DIR)/ShapeTest.java\
		  $(TEST_DIR)/TwoDimensionalShapeTest.java\
		  $(TEST_DIR)/ThreeDimensionalShapeTest.java\
		  $(TEST_DIR)/CircleTest.java\
		  $(TEST_DIR)/SquareTest.java\
		  $(TEST_DIR)/TriangleTest.java\
		  $(TEST_DIR)/RectangleTest.java\
		  $(TEST_DIR)/Project1Test.java\
		  $(TEST_DIR)/ConeTest.java\
		  $(TEST_DIR)/CubeTest.java\
		  $(TEST_DIR)/CylinderTest.java\
		  $(TEST_DIR)/SphereTest.java\
		  $(TEST_DIR)/TorusTest.java\
          $(TEST_DIR)/TestRunner.java


# Rule to compile .class files in the bin directory
compile:
	@echo "Compiling Java sources..."
	mkdir -p $(BIN_DIR)
	$(JCC) --module-path $(LIB_DIR) --add-modules javafx.controls,javafx.fxml -d $(BIN_DIR) $(SOURCES)
	@echo "Compilation complete."

# Rule to generate JSON file
generate_json_file: compile
	cd $(BIN_DIR) && $(JVM) --module-path "../$(LIB_DIR)" --add-modules javafx.controls,javafx.fxml -cp .:../$(SRC_DIR) test.GenerateTestFile

# Rule to generate JSON file and run tests
run_tests: generate_json_file
	cd $(BIN_DIR) && $(JVM) --module-path "../$(LIB_DIR)" --add-modules javafx.controls,javafx.fxml -DprojectState=test -cp .:../$(SRC_DIR) test.TestRunner

# Rule to generate JSON file and run project
run_project: generate_json_file
	cd $(BIN_DIR) && $(JVM) --module-path "../$(LIB_DIR)" --add-modules javafx.controls,javafx.fxml -DprojectState=prod -cp .:../$(SRC_DIR) main.Project1

# Rule to clean up
clean:
	rm -rf $(DOC_DIR)/*.txt
	rm -rf $(BIN_DIR)
