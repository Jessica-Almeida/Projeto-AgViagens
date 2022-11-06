using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace DestinoAPI.Models
{
    [Table("Destino")]
    public class Destino
    {
        [Key]
        public int DestinoId { get; set; }

        [Required(ErrorMessage = "Informe o país do destino")]
        [StringLength(50)]
        public string Pais { get; set; }

        [Required(ErrorMessage = "Informe a cidade do destino")]
        [StringLength(50)]
        public string Cidade { get; set; }

        [Required(ErrorMessage = "Informe a data de ida do destino")]
        [StringLength(10)]
        public string DataIda { get; set; }

        [Required(ErrorMessage = "Informe a data de volta do destino")]
        [StringLength(10)]
        public string DataVolta { get; set; }

        [Required(ErrorMessage = "Informe o preço do destino")]
        public double Preco { get; set; }
    }
}
