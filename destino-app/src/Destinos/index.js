import React, { Component } from 'react';
import { View, Text, StyleSheet } from 'react-native';


class Destinos extends Component {
    render() {
        return (
            <View style={styles.box}>
                <Text>
                    <Text style={styles.texto1}> País:</Text>
                    <Text style={styles.texto2}> {this.props.data.pais}</Text>
                </Text>
                <Text>
                    <Text style={styles.texto1}> Cidade:</Text>
                    <Text style={styles.texto2}> {this.props.data.cidade}</Text>
                </Text>
                <Text>
                    <Text style={styles.texto1}> Data de ida:</Text>
                    <Text style={styles.texto2}> {this.props.data.dataIda}</Text>
                </Text>
                <Text>
                    <Text style={styles.texto1}> Data de volta:</Text>
                    <Text style={styles.texto2}> {this.props.data.dataVolta}</Text>
                </Text>
                <Text>
                    <Text style={styles.texto1}> Preço:</Text>
                    <Text style={styles.texto2}> {this.props.data.preco}</Text>
                </Text>

            </View>
        );
    }
}

export default Destinos;

const styles = StyleSheet.create({
    box: {
        backgroundColor: '#E6E6FA',
        padding: 30,
        margin: 10,

    },

    texto1: {

        fontWeight: 'bold',
        fontSize: 16,
    },
    texto2: {
        fontSize: 16,
    },
});





