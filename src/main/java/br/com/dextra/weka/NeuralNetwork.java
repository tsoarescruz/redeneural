package br.com.dextra.weka;

import java.io.FileReader;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;

public class NeuralNetwork {

	public static void main(String[] args) throws Exception {

		FileReader reader = new FileReader("/home/everton.gago/projetos/redeneural/iris.arff");
		Instances instances = new Instances(reader);
		instances.setClassIndex(4);

		MultilayerPerceptron neuralNets = new MultilayerPerceptron();
		neuralNets.buildClassifier(instances);

		int asserts = 0;
		int numInstances = instances.numInstances();

		for (int i = 0; i < numInstances; i++) {
			Instance instance = instances.instance(i);
			double type = neuralNets.classifyInstance(instance);
			if (type == instance.classValue()) {
				asserts++;
			}
		}

		System.out.printf("De %d instancias %d foram classificadas corretamente.", numInstances, asserts);


	}

}